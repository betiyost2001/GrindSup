import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { SearchIcon, EditIcon, DeleteIcon, AddIcon } from "@chakra-ui/icons";
import {
  Heading,
  InputGroup,
  InputLeftElement,
  Input,
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  TableContainer,
  Select,
  Button,
  HStack,
  Box,
  Flex,
  Spinner,
  Center,
  Text,
  useToast,
} from "@chakra-ui/react";

const AlumnoList = () => {
  const [alumnos, setAlumnos] = useState([]);
  const [estados, setEstados] = useState([]);
  const [search, setSearch] = useState("");
  const [loading, setLoading] = useState(true);
  const navigate = useNavigate();
  const toast = useToast();

  // 🔹 Cargar alumnos
  const fetchAlumnos = () => {
    axios
      .get("http://localhost:8080/api/alumnos")
      .then((res) => setAlumnos(res.data))
      .catch((err) => console.error("Error al cargar alumnos:", err))
      .finally(() => setLoading(false));
  };

  // 🔹 Cargar estados
  const fetchEstados = () => {
    axios
      .get("http://localhost:8080/api/estados")
      .then((res) => setEstados(res.data))
      .catch((err) => console.error("Error al cargar estados:", err));
  };

  useEffect(() => {
    fetchAlumnos();
    fetchEstados();
  }, []);

  // 🔄 Cambiar estado de un alumno
  const handleEstadoChange = (idAlumno, idEstado) => {
    axios
      .put(`http://localhost:8080/api/alumnos/${idAlumno}`, {
        ...alumnos.find((a) => a.id_alumno === idAlumno),
        estado: { id_estado: idEstado },
      })
      .then(() => {
        toast({
          title: "Estado actualizado",
          status: "success",
          duration: 2000,
          isClosable: true,
        });
        fetchAlumnos(); // refrescar lista
      })
      .catch((err) => {
        console.error("Error al actualizar estado:", err);
        toast({
          title: "Error al actualizar estado",
          status: "error",
          duration: 2000,
          isClosable: true,
        });
      });
  };

  // 🗑️ Eliminar alumno
  const handleDelete = (idAlumno) => {
    axios
      .delete(`http://localhost:8080/api/alumnos/${idAlumno}`)
      .then(() => {
        toast({
          title: "Alumno eliminado",
          status: "success",
          duration: 2000,
          isClosable: true,
        });
        fetchAlumnos();
      })
      .catch((err) => {
        console.error("Error al eliminar alumno:", err);
        toast({
          title: "Error al eliminar",
          status: "error",
          duration: 2000,
          isClosable: true,
        });
      });
  };

  // 🔍 Filtrar alumnos por búsqueda
  const filteredAlumnos = alumnos.filter((alumno) => {
    const query = search.toLowerCase();
    return (
      alumno.nombre?.toLowerCase().includes(query) ||
      alumno.apellido?.toLowerCase().includes(query) ||
      alumno.documento?.toLowerCase().includes(query)
    );
  });

  if (loading) {
    return (
      <Center py={20}>
        <Spinner size="xl" color="teal.500" />
      </Center>
    );
  }

  return (
    <Box mt={10} w="100%">
      <Flex justify="space-between" align="center" mb={6} px={8}>
        <Heading as="h2" size="lg" color="teal.600">
          Lista de Alumnos
        </Heading>
        <InputGroup w="350px">
          <InputLeftElement pointerEvents="none">
            <SearchIcon color="gray.400" />
          </InputLeftElement>
          <Input
            placeholder="Buscar por nombre, apellido o documento"
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            bg="white"
            borderRadius="full"
            boxShadow="sm"
          />
        </InputGroup>
      </Flex>

      {filteredAlumnos.length === 0 ? (
        <Center py={10}>
          <Text fontSize="lg" color="gray.500">
            No se encontraron alumnos.
          </Text>
        </Center>
      ) : (
        <TableContainer w="100%" maxW="100%" px={8}>
          <Table variant="striped" colorScheme="teal" size="md">
            <Thead>
              <Tr>
                <Th>Nombre</Th>
                <Th>Apellido</Th>
                <Th>Documento</Th>
                <Th>Teléfono</Th>
                <Th>Estado</Th>
                <Th textAlign="center">Opciones</Th>
              </Tr>
            </Thead>
            <Tbody>
              {filteredAlumnos.map((alumno) => (
                <Tr key={alumno.id_alumno} _hover={{ bg: "teal.50" }}>
                  <Td>{alumno.nombre}</Td>
                  <Td>{alumno.apellido}</Td>
                  <Td>{alumno.documento}</Td>
                  <Td>{alumno.telefono}</Td>
                  <Td>
                    <Select
                      size="sm"
                      value={alumno.estado?.id_estado || ""}
                      onChange={(e) =>
                        handleEstadoChange(alumno.id_alumno, e.target.value)
                      }
                    >
                      {estados.map((estado) => (
                        <option key={estado.id_estado} value={estado.id_estado}>
                          {estado.nombre}
                        </option>
                      ))}
                    </Select>
                  </Td>
                  <Td>
                    <HStack spacing={3} justify="center">
                      <Button
                        size="sm"
                        colorScheme="blue"
                        leftIcon={<EditIcon />}
                      >
                        Editar
                      </Button>
                      <Button
                        size="sm"
                        colorScheme="red"
                        leftIcon={<DeleteIcon />}
                        onClick={() => handleDelete(alumno.id_alumno)}
                      >
                        Eliminar
                      </Button>
                    </HStack>
                  </Td>
                </Tr>
              ))}
            </Tbody>
          </Table>
        </TableContainer>
      )}

      <Flex justify="center" px={8} mt={6}>
        <Button
          colorScheme="teal"
          leftIcon={<AddIcon />}
          onClick={() => navigate("/alumno/registrar")}
        >
          Agregar Alumno
        </Button>
      </Flex>
    </Box>
  );
};

export default AlumnoList;
