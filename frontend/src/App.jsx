import { Box, Container } from "@chakra-ui/react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import RegistrarAlumnoForm from "./pages/Alumno/RegistrarAlumnoForm";
import AlumnoList from "./components/AlumnoList";

export default function App() {
  return (
    <BrowserRouter>
      <Box minH="100vh" display="flex" flexDirection="column">
        <Header />
        <Box as="main" flex="1" py={{ base: 6, md: 10 }}>
          <Container maxW="container.xl">
            <Routes>
              <Route path="/" element={<AlumnoList />} />
              <Route path="/alumno/registrar" element={<RegistrarAlumnoForm />} />
            </Routes>
          </Container>
        </Box>
        <Footer />
      </Box>
    </BrowserRouter>
  );
}

