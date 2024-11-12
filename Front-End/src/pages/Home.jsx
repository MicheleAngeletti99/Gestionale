import { Slide } from "../components/Slide";
import Slide2 from "../assets/Slide1.jpg";
import { Card } from "../components/Card";

export function Home({ prop1, prop2 }) {
  return (
    <div onClick={prop1} onChange={prop2}>
      <Slide imageSrc={Slide2} imageAlt="image slide" title="Wharehouse Manager" description="teststststtstatsta" />

      <div className="max-w-7xl m-auto flex flex-wrap">
        <Card type="price" tPrice="Basic" />
        <Card type="price" tPrice="Advance" price="€ 19.99" />
        <Card type="price" tPrice="Premium" price="€ 49.99" />
      </div>
      <Card type="service" />
      <Card type="customer" />
    </div>
  );
}
