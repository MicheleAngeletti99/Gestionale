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
    <nav className="fixed top-0 z-10 w-screen h-20 border-b-2 border-solid border-gray-300 px-3 bg-white flex flex-row items-center justify-between ">
      <section className="flex flex-row items-center gap-3">
        <ImgLogo src={src} alt="Home Page" onClick={handleHome} />
        <TitleXL text="StockHub" />
      </section>
      <section className="h-full flex flex-row items-center justify-center gap-3 cursor-pointer">
        <section
          className="h-full flex items-center justify-center"
          onMouseEnter={() => setHoverProducts(true)}
          onMouseLeave={() => setHoverProducts(false)}
        >
          <Title3xl text="Products" cursorPointer="disable" height="auto" />
          {hoverProducts && (
            <ul
              onMouseEnter={() => setHoverProducts(true)}
              onMouseLeave={() => setHoverProducts(false)}
              className="fixed top-20 bg-white w-32 p-2 flex flex-col"
            >
              <LinkPage
                onClick={() => handleWarehouseHome()}
                text="Warehouse"
                style="secondary"
              />
              <LinkPage
                onClick={handlePubRestaurantHome}
                text="Pub/Restaurant"
                style="secondary"
              />
              <LinkPage
                onClick={handlePharmacyHome}
                text="Pharmacy"
                style="secondary"
              />
            </ul>
          )}
        </section>
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
