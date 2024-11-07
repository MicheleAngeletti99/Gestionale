import src from "../assets/react.svg";
import { Button } from "./Button";
import { ImgLogo } from "./ImgLogo";
import { LinkPage } from "./LinkPage";
import { Title3xl } from "./Title3xl";

export function Navbar() {
  return (
    <nav className="w-screen h-20 border-b-2 border-solid border-gray-300 p-2 flex flex-row items-center justify-between ">
      <section className="flex flex-row items-center gap-3">
        <ImgLogo src={src} alt="Home Page" />
        <Title3xl text="StockHub" />
      </section>
      <section className="flex flex-row items-center gap-3">
        <LinkPage onClick="" text="Products" />
        <LinkPage onClick="" text="Solutions" />
        <LinkPage onClick="" text="Resources" />
        <LinkPage onClick="" text="Price" />
        <Button onClick="" text="Get Started" />
        <Button onClick="" text="Request a Demo" />
      </section>
    </nav>
  );
}
