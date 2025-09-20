import React, { useEffect, useMemo, useState } from "react";
import {
  Box,
  Button,
  Card,
  CardBody,
  CardHeader,
  Container,
  Grid,
  GridItem,
  Heading,
  Input,
  Stack,
  Text,
  useToast,
  FormControl,
  FormLabel,
  FormErrorMessage,
  Spinner,
  Menu,
  MenuButton,
  MenuList,
  MenuItem,
  Textarea,
} from "@chakra-ui/react";
import { ChevronDownIcon } from "@chakra-ui/icons";

export default function RegistrarAlumnoForm({
  apiBaseUrl = import.meta?.env?.VITE_API_BASE_URL || "http://localhost:8080/api",
  usarMock = false,
}) {
  const toast = useToast();
  const [submitting, setSubmitting] = useState(false);
  const [submitted, setSubmitted] = useState(false);

  const [form, setForm] = useState({
    nombre: "",
    apellido: "",
    documento: "",
    fechaNac: "",
    peso: "",
    altura: "",
    lesiones: "",
    codigoArea: "+54",
    contactoNumero: "",
  });

  const [codigos, setCodigos] = useState([]);
  const [loadingCodigos, setLoadingCodigos] = useState(true);

  useEffect(() => {
    const fetchCodes = async () => {
      try {
        const res = await fetch("https://restcountries.com/v3.1/all?fields=cca2,idd,name");
        const data = await res.json();

        const parsed = data
          .filter((c) => c?.idd?.root)
          .flatMap((c) => {
            const root = c.idd.root; // ej: +54
            const suffixes = c.idd.suffixes?.length ? c.idd.suffixes : [""];
            return suffixes.map((suf) => ({
              code: `${root}${suf}`,
              country: c.name?.common ?? "",
            }));
          })
          .filter((x) => x.code)
          .sort((a, b) => a.country.localeCompare(b.country, "es"));

        // Argentina primero (opcional)
        parsed.sort((a, b) =>
          a.country === "Argentina" ? -1 : b.country === "Argentina" ? 1 : 0
        );

        setCodigos(parsed);
      } catch (err) {
        console.error("Error al cargar códigos de área", err);
      } finally {
        setLoadingCodigos(false);
      }
    };
    fetchCodes();
  }, []);

  const errors = useMemo(() => {
    const e = {};
    if (!form.nombre?.trim()) e.nombre = "El nombre es obligatorio";
    if (!form.apellido?.trim()) e.apellido = "El apellido es obligatorio";

    if (!form.documento?.trim()) e.documento = "El documento es obligatorio";
    else if (!/^[0-9]+$/.test(form.documento)) e.documento = "El DNI debe contener solo números";

    if (!form.fechaNac?.trim()) e.fechaNac = "La fecha de nacimiento es obligatoria";
    else {
      const hoy = new Date().toISOString().split("T")[0];
      if (form.fechaNac > hoy) e.fechaNac = "La fecha no puede ser futura";
    }

    if (form.peso && !/^[0-9]+$/.test(form.peso)) e.peso = "El peso debe ser numérico";
    if (form.altura && !/^[0-9]+$/.test(form.altura)) e.altura = "La altura debe ser numérica";
    if (form.contactoNumero && !/^[0-9]+$/.test(form.contactoNumero))
      e.contactoNumero = "El número debe ser numérico";

    return e;
  }, [form]);

  const isValid = Object.keys(errors).length === 0;
  const handleChange = (e) => setForm((p) => ({ ...p, [e.target.name]: e.target.value }));
  const hoy = new Date().toISOString().split("T")[0];

  const buildPayload = () => ({
    nombre: form.nombre.trim(),
    apellido: form.apellido.trim(),
    documento: form.documento.trim(),
    fechaNacimiento: form.fechaNac,
    peso: form.peso ? Number(form.peso) : null,
    altura: form.altura ? Number(form.altura) : null,
    lesiones: form.lesiones?.trim() || null,
    telefono: form.codigoArea + form.contactoNumero,

    // 👇 Clave para que no falle en el backend:
    estado: { id_estado: 1 }, // Activo
    entrenador: null,          // Sin entrenador asignado
  });

  const submitMock = () => new Promise((r) => setTimeout(() => r({ ok: true }), 700));

  const onSubmit = async (e) => {
    e.preventDefault();
    setSubmitted(true);
    if (!isValid) {
      toast({ status: "warning", title: "Revisá los campos obligatorios", position: "top" });
      return;
    }
    setSubmitting(true);
    try {
      const payload = buildPayload();
      if (usarMock) {
        await submitMock();
      } else {
        const res = await fetch(`${apiBaseUrl}/alumnos`, {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(payload),
        });
        if (!res.ok) {
          // intentar leer mensaje del back
          let msg = "Error al registrar";
          try {
            const j = await res.json();
            if (j?.message) msg = j.message;
          } catch {}
          throw new Error(msg);
        }
        await res.json();
      }
      toast({ status: "success", title: "Alumno registrado", position: "top" });
      setForm({
        nombre: "",
        apellido: "",
        documento: "",
        fechaNac: "",
        peso: "",
        altura: "",
        lesiones: "",
        codigoArea: "+54",
        contactoNumero: "",
      });
      setSubmitted(false);
    } catch (err) {
      toast({
        status: "error",
        title: "No se pudo registrar",
        description: err.message,
        position: "top",
      });
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <Box py={{ base: 8, md: 12 }}>
      <Container maxW="container.sm">
        <Card>
          <CardHeader textAlign="center" pb={0}>
            <Heading size="2xl" color="brand.700">GrindSup</Heading>
            <Heading size="lg" mt={2}>Registrar Alumno</Heading>
            <Text color="gray.600" mt={2}>
              Por favor, complete las casillas obligatorias para continuar.
            </Text>
          </CardHeader>

          <CardBody pt={6} px={{ base: 6, md: 10 }} pb={8}>
            <Box as="form" onSubmit={onSubmit}>
              <Grid templateColumns={{ base: "1fr", md: "1fr 1fr" }} gap={5}>
                {/* Nombre */}
                <GridItem>
                  <FormControl isRequired isInvalid={submitted && !!errors.nombre}>
                    <FormLabel>Nombre</FormLabel>
                    <Input
                      name="nombre"
                      placeholder="Ej: Betina"
                      value={form.nombre}
                      onChange={handleChange}
                      _placeholder={{ color: "gray.400" }}
                    />
                    {submitted && <FormErrorMessage>{errors.nombre}</FormErrorMessage>}
                  </FormControl>
                </GridItem>

                {/* Apellido */}
                <GridItem>
                  <FormControl isRequired isInvalid={submitted && !!errors.apellido}>
                    <FormLabel>Apellido</FormLabel>
                    <Input
                      name="apellido"
                      placeholder="Ej: Yost"
                      value={form.apellido}
                      onChange={handleChange}
                      _placeholder={{ color: "gray.400" }}
                    />
                    {submitted && <FormErrorMessage>{errors.apellido}</FormErrorMessage>}
                  </FormControl>
                </GridItem>

                {/* DNI */}
                <GridItem>
                  <FormControl isRequired isInvalid={submitted && !!errors.documento}>
                    <FormLabel>Documento (DNI)</FormLabel>
                    <Input
                      name="documento"
                      placeholder="Ej: 40123456"
                      value={form.documento}
                      onChange={handleChange}
                      _placeholder={{ color: "gray.400" }}
                    />
                    {submitted && <FormErrorMessage>{errors.documento}</FormErrorMessage>}
                  </FormControl>
                </GridItem>

                {/* Fecha de nacimiento */}
                <GridItem>
                  <FormControl isRequired isInvalid={submitted && !!errors.fechaNac}>
                    <FormLabel>Fecha de nacimiento</FormLabel>
                    <Input
                      type="date"
                      name="fechaNac"
                      max={hoy}
                      value={form.fechaNac}
                      onChange={handleChange}
                    />
                    {submitted && <FormErrorMessage>{errors.fechaNac}</FormErrorMessage>}
                  </FormControl>
                </GridItem>

                {/* Peso */}
                <GridItem>
                  <FormControl isInvalid={submitted && !!errors.peso}>
                    <FormLabel>Peso (kg)</FormLabel>
                    <Input
                      type="number"
                      name="peso"
                      placeholder="Ej: 70"
                      value={form.peso}
                      onChange={handleChange}
                      _placeholder={{ color: "gray.400" }}
                    />
                    {submitted && <FormErrorMessage>{errors.peso}</FormErrorMessage>}
                  </FormControl>
                </GridItem>

                {/* Altura */}
                <GridItem>
                  <FormControl isInvalid={submitted && !!errors.altura}>
                    <FormLabel>Altura (cm)</FormLabel>
                    <Input
                      type="number"
                      name="altura"
                      placeholder="Ej: 170"
                      value={form.altura}
                      onChange={handleChange}
                      _placeholder={{ color: "gray.400" }}
                    />
                    {submitted && <FormErrorMessage>{errors.altura}</FormErrorMessage>}
                  </FormControl>
                </GridItem>

                {/* Contacto */}
                <GridItem colSpan={{ base: 1, md: 2 }}>
                  <FormControl isInvalid={submitted && !!errors.contactoNumero}>
                    <FormLabel>Contacto</FormLabel>
                    <Stack direction="row" spacing={3} align="center">
                      {loadingCodigos ? (
                        <Button variant="outline" isDisabled rightIcon={<Spinner size="sm" />}>
                          {form.codigoArea}
                        </Button>
                      ) : (
                        <Menu>
                          <MenuButton
                            as={Button}
                            variant="outline"
                            rightIcon={<ChevronDownIcon />}
                            minW="120px"
                          >
                            {form.codigoArea}
                          </MenuButton>
                          <MenuList maxH="280px" overflowY="auto">
                            {codigos.map((c) => (
                              <MenuItem
                                key={c.code + c.country}
                                onClick={() => setForm((p) => ({ ...p, codigoArea: c.code }))}
                              >
                                {c.code} ({c.country})
                              </MenuItem>
                            ))}
                          </MenuList>
                        </Menu>
                      )}
                      <Input
                        name="contactoNumero"
                        placeholder="123456789"
                        value={form.contactoNumero}
                        onChange={handleChange}
                        _placeholder={{ color: "gray.400" }}
                      />
                    </Stack>
                    {submitted && <FormErrorMessage>{errors.contactoNumero}</FormErrorMessage>}
                  </FormControl>
                </GridItem>

                {/* Historial de lesiones */}
                <GridItem colSpan={{ base: 1, md: 2 }}>
                  <FormControl>
                    <FormLabel>Historial de lesiones</FormLabel>
                    <Textarea
                      name="lesiones"
                      placeholder="Opcional"
                      value={form.lesiones}
                      onChange={handleChange}
                      rows={4}
                      _placeholder={{ color: "gray.400" }}
                    />
                  </FormControl>
                </GridItem>
              </Grid>

              <Stack direction={{ base: "column", md: "row" }} spacing={4} mt={8} justify="center">
                <Button type="submit" isLoading={submitting} loadingText="Guardando" px={10}>
                  Registrar
                </Button>
                <Button
                  variant="ghost"
                  onClick={() => {
                    setForm({
                      nombre: "",
                      apellido: "",
                      documento: "",
                      fechaNac: "",
                      peso: "",
                      altura: "",
                      lesiones: "",
                      codigoArea: "+54",
                      contactoNumero: "",
                    });
                    setSubmitted(false);
                  }}
                >
                  Cancelar
                </Button>
              </Stack>
            </Box>
          </CardBody>
        </Card>
      </Container>
    </Box>
  );
}
