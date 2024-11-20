import { Route, Routes } from "react-router-dom";

import { Home } from "./pages/Home";
import { Container } from "./Container";
import { Navbar } from "./components/Navbar";
import { GestionaleHome } from "./pages/GestionaleHome";
import { Warehouse } from "./components/Warehouse";

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
        <Route path="/gestionale_warehouse" element={<GestionaleHome />}>
          <Route path="Warehouse" element={<Warehouse />} />
        </Route>
      </Routes>
    </Container>
  );
}

export default App;
