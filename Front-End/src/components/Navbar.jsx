import { useNavigate } from "react-router-dom";
import src from "../assets/react.svg";
import { Button } from "./Button";
import { ImgLogo } from "./ImgLogo";
import { LinkPage } from "./LinkPage";
import { TitleXL } from "./TitleXL";
import { useState } from "react";
import { Title3xl } from "./Title3xl";

export function Navbar() {
  const navigate = useNavigate();
  const [hoverProducts, setHoverProducts] = useState(false);

  // DropDown per le resources che mostreranno 3 li: 1-Warehouse 2-Pub/Restaurant 3-Pharmacy
  const [hoverResources, setHoverResources] = useState(false);

  function handleGetStarted() {
    navigate("/get_started");
  }
  function handleHome() {
    navigate("/");
  }
  function handleWarehouseHome() {
    navigate("/gestionale_warehouse");
  }
  function handlePubRestaurantHome() {
    navigate("/gestionale_pub_restaurant");
  }
  function handlePharmacyHome() {
    navigate("/gestionale_pharmacy");
  }

  return (
    <nav className="w-full h-20 border-b-2 border-solid border-gray-300 p-2 flex flex-row items-center justify-between ">
      <section className="flex flex-row items-center gap-3">
        <ImgLogo src={src} alt="Home Page" onClick={handleHome} />
        <TitleXL text="StockHub" />
      </section>
      <section className="flex flex-row items-center gap-3">
        <LinkPage
          onClick={handleWarehouseHome}
          onMouseEnter={() => setHoverProducts(true)}
          onMouseLeave={() => setHoverProducts(false)}
          text="Products"
        />
        {setHoverProducts && (
          <ul className="absolute top-20 bg-white z-10 w-32 p-2 flex flex-col">
            <li>Warehouse</li>
            <li>Pub/Restaurant</li>
            <li>Pharmacy</li>
          </ul>
        )}
        <LinkPage onClick={handleGetStarted} text="Solutions" />
        <LinkPage onClick={handleGetStarted} text="Resources" />
        <LinkPage onClick={handleGetStarted} text="Price" />
        <Button
          onClick={handleGetStarted}
          text="Get Started"
          fontSize="thirdy"
        />
        <Button
          onClick={handleGetStarted}
          text="Request a Demo"
          fontSize="secondary"
        />
      </section>
    </nav>
  );
}
