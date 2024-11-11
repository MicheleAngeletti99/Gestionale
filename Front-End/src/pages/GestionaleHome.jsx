import { useEffect, useState } from "react";
import { Title3xl } from "../components/Title3xl";

export function GestionaleHome() {
  const [products, setProducts] = useState();
  const [error, setError] = useState();

  async function fetchProducts() {
    try {
      const response = await fetch("http://localhost:3000/all");
      const data = await response.json();

      if (response.ok) {
        throw new Error();
      }

      setProducts(data);
    } catch (err) {
      setError(err);
      console.error(err);
    }
  }

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <>
      <section>
        <Title3xl text="Gestionale Home" />
        <section>
          <h2>Prodotti in Sede</h2>
          {/* <Card /> */}
          {/* {error ? (
            <h3>There is an error, sorry we resolve all</h3>
          ) : (
            <ul>
              {products.map((product) => (
                <li key={product.id}>
                  <img src={product.img} alt={`Immagine ${product.name}`} />
                  <h4>product.name</h4>
                  <h4>product.description</h4>
                  <h4>product.dateIn</h4>
                  <h4>product.quantity</h4>
                </li>
              ))}
            </ul>
          )} */}
        </section>
      </section>
    </>
  );
}
