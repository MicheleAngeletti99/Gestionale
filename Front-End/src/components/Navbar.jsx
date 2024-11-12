import { useNavigate } from "react-router-dom";
import src from "../assets/react.svg";
import { Button } from "./Button";
import { ImgLogo } from "./ImgLogo";
import { LinkPage } from "./LinkPage";
import { TitleXL } from "./TitleXL";
import { useState } from "react";

export function Navbar() {
  const navigate = useNavigate();
  const [hover, setHover] = useState(false);

  function handleGetStarted() {
    navigate("/get_started");
  }
  function handleHome() {
    navigate("/");
  }
  function handleGestionaleHome() {
    navigate("/gestionale_magazzino");
  }

  return (
    <nav className="w-full h-20 border-b-2 border-solid border-gray-300 p-2 flex flex-row items-center justify-between ">
      <section className="flex flex-row items-center gap-3">
        <ImgLogo src={src} alt="Home Page" onClick={handleHome} />
        <TitleXL text="StockHub" />
      </section>
      <section className="flex flex-row items-center gap-3">
        <LinkPage onClick={handleGestionaleHome} onMouseEnter={() => setHover(true)} onMouseLeave={() => setHover(false)} text="Products" />
        {hover && (
          <ul className="absolute top-20 bg-white z-10 w-32 p-2 flex flex-col">
            <li>Warehouse</li>
            <li>Pub/Restaurant</li>
            <li>Pharmacy</li>
          </ul>
        )}
        <LinkPage onClick={handleGetStarted} text="Solutions" />
        <LinkPage onClick={handleGetStarted} text="Resources" />
        <LinkPage onClick={handleGetStarted} text="Price" />
        <Button onClick={handleGetStarted} text="Get Started" fontSize="thirdy" />
        <Button onClick={handleGetStarted} text="Request a Demo" fontSize="secondary" />
      </section>
    </nav>
  );
}
