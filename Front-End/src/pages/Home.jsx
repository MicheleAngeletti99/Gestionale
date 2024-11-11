import { Slide } from "../components/Slide";
import Slide2 from "../assets/Slide1.jpg";
import { Card } from "../components/Card";

export function Home({ prop1, prop2 }) {
  return (
    <div onClick={prop1} onChange={prop2}>
      <Slide imageSrc={Slide2} imageAlt="image slide" title="Wharehouse Manager" description="teststststtstatsta" />

      <Card type="price" />
      <Card type="service" />
      <Card type="customer" />
    </div>
  );
}
