import src from "../assets/react.svg";
import { Button } from "./Button";
import { ImgLogo } from "./ImgLogo";
import { LinkPage } from "./LinkPage";
import { TitleXL } from "./TitleXL";

export function Navbar() {
  return (
    <nav className="w-screen h-20 border-b-2 border-solid border-gray-300 p-2 flex flex-row items-center justify-between ">
      <section className="flex flex-row items-center gap-3">
        <ImgLogo src={src} alt="Home Page" />
        <TitleXL text="StockHub" />
      </section>
      <section className="flex flex-row items-center gap-3">
        <LinkPage onClick="" text="Products" />
        <LinkPage onClick="" text="Solutions" />
        <LinkPage onClick="" text="Resources" />
        <LinkPage onClick="" text="Price" />
        <Button onClick="" text="Get Started" fontSize="thirdy" />
        <Button onClick="" text="Request a Demo" fontSize="secondary" />
      </section>
    </nav>
  );
}
