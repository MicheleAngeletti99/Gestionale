import { useNavigate } from "react-router-dom";
import src from "../assets/react.svg";
import { Button } from "./Button";
import { ImgLogo } from "./ImgLogo";
import { LinkPage } from "./LinkPage";
import { TitleXL } from "./TitleXL";

export function Navbar() {
  const navigate = useNavigate();

  function handleGetStarted() {
    navigate("/get_started");
  }
  function handleHome() {
    navigate("/");
  }

  return (
    <nav className="w-screen h-20 border-b-2 border-solid border-gray-300 p-2 flex flex-row items-center justify-between ">
      <section className="flex flex-row items-center gap-3">
        <ImgLogo src={src} alt="Home Page" onClick={handleHome} />
        <TitleXL text="StockHub" />
      </section>
      <section className="flex flex-row items-center gap-3">
        <LinkPage onClick={handleGetStarted} text="Products" />
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
