import { Card } from "../components/Card";
import { Hero } from "../components/Hero";

export function Home({ prop1, prop2 }) {
  return (
    <div onClick={prop1} onChange={prop2}>
      <Hero />
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
