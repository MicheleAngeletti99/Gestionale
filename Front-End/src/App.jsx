import { Route, Routes } from "react-router-dom";

import { Home } from "./pages/Home";
import { Container } from "./Container";
import { Navbar } from "./components/Navbar";
import { GestionaleHome } from "./pages/GestionaleHome";

function App() {
  return (
    <Container
      navbar={<Navbar />}
      // footer={<Footer />}
    >
      <Routes>
        {/* Home */}
        <Route path="/" element={<Home />} />

        {/* Gestionale Magazzino */}
        <Route path="/gestionale_magazzino" element={<GestionaleHome />} />
      </Routes>
    </Container>
  );
}

export default App;
