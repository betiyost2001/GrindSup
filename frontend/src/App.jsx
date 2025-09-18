import { Box, Container } from "@chakra-ui/react";
import Header from "./components/Header";
import Footer from "./components/Footer";
import RegistrarAlumnoForm from "./pages/Alumno/RegistrarAlumnoForm";

export default function App() {
  return (
    <Box minH="100vh" display="flex" flexDirection="column">
      <Header />
      <Box as="main" flex="1" py={{ base: 6, md: 10 }}>
        <Container maxW="container.md">
          <RegistrarAlumnoForm />
        </Container>
      </Box>
      <Footer />
    </Box>
  );
}
