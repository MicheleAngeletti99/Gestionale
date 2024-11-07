import { BrowserRouter } from "react-router-dom";
import "./App.css";
import { Navbar } from "./components/Navbar";
import { Slide } from "./components/Slide";
import Slide2 from "./assets/Slide2.jpg";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Slide
        imageSrc={Slide2}
        imageAlt="image slide"
        title="Wharehouse Manager"
        description="teststststtstatsta"
      />
    </BrowserRouter>
  );
}

export default App;
