import { Button } from "./Button";
import { Link } from "react-router-dom";

export function Navbar() {
  return (
    <nav className="w-full bg-transparent shadow-sm">
      <div className="max-w-7xl m-auto flex justify-between items-center p-1">
        {/* Logo */}
        <div className="">
          <Link to="/">LOGO</Link>
        </div>

        {/* Lista degli elementi di navigazione */}
        <div>
          <Link to="/">Home</Link>
          <Link to="/about">About</Link>
          <Link to="/services">Services</Link>
          <Link to="/contact">Contact</Link>
        </div>
        {/* Pulsanti */}
        <div className="">
          <Link to="/getstarted">
            <Button text="Get Started" />
          </Link>
          <Link to="/account">
            <Button style="error" size="md" text="test" />
          </Link>
        </div>
      </div>
    </nav>
  );
}
