import {
  Box,
  Container,
  Flex,
  HStack,
  Text,
  Button,
  IconButton,
  Menu,
  MenuButton,
  MenuList,
  MenuItem,
} from "@chakra-ui/react";
import { HamburgerIcon } from "@chakra-ui/icons";

export default function Header() {
  return (
    <Box
      as="header"
      bg="white"
      borderBottom="1px"
      borderColor="gray.200"
      /* 👇 sin position sticky/fixed */
    >
      <Container maxW="container.xl" py={3}>
        <Flex align="center" minH="64px">
          <Flex w={{ base: "auto", md: "220px" }} align="center">
            <Text fontWeight="bold" fontSize="xl" color="brand.600">
              GrindSup
            </Text>
          </Flex>

          <Flex flex="1" justify="center">
            <HStack spacing={8} display={{ base: "none", md: "flex" }} fontWeight={500} color="gray.700">
              <Text _hover={{ color: "brand.600", cursor: "pointer" }}>Inicio</Text>
              <Text _hover={{ color: "brand.600", cursor: "pointer" }}>Alumnos</Text>
              <Text _hover={{ color: "brand.600", cursor: "pointer" }}>Entrenadores</Text>
              <Text _hover={{ color: "brand.600", cursor: "pointer" }}>Contacto</Text>
            </HStack>

            <Menu>
              <MenuButton
                as={IconButton}
                icon={<HamburgerIcon />}
                aria-label="Abrir menú"
                display={{ base: "inline-flex", md: "none" }}
                variant="ghost"
              />
              <MenuList>
                <MenuItem>Inicio</MenuItem>
                <MenuItem>Alumnos</MenuItem>
                <MenuItem>Entrenadores</MenuItem>
                <MenuItem>Contacto</MenuItem>
              </MenuList>
            </Menu>
          </Flex>

          <Flex w={{ base: "auto", md: "220px" }} justify="flex-end">
            <Button size="sm" colorScheme="brand">Iniciar sesión</Button>
          </Flex>
        </Flex>
      </Container>
    </Box>
  );
}
