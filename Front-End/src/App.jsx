import { Route, Routes } from "react-router-dom";

import { Home } from "./pages/Home";
import { Container } from "./Container";
import { Navbar } from "./components/Navbar";

function App() {
  return (
    <Container
      navbar={<Navbar />}
      // footer={<Footer />}
    >
      <Routes>
        {/* Home */}
        <Route path="/" element={<Home />} />
      </Routes>
    </Container>
  );
}

export default App;
