import { useEffect, useState } from "react";
import { Title3xl } from "../components/Title3xl";
import { Button } from "../components/Button";

export function GestionaleHome() {
  const [products, setProducts] = useState();
  const [error, setError] = useState();
  const [test, setTest] = useState([]);
  const [form, setForm] = useState({
    nomeAttivita: "",
    email: "",
    password: "",
    indirizzo: "",
    tipologiaAttivita: "",
  });

  async function fetchProducts() {
    try {
      const response = await fetch("http://localhost:3001/magazzino/all");
      const data = await response.json();

      if (!response.ok) {
        throw new Error();
      }
      console.log(data);
      setProducts(data);
    } catch (err) {
      setError(err);
      console.error(err);
    }
  }

  useEffect(() => {
    fetchProducts();
  }, []);

  async function handleCreateWarehouse(e) {
    // private String nomeAttivita;
    // private String email;
    // private String password;
    // private String indirizzo;
    // private String tipologiaAttivita;
    e.preventDefault();

    try {
      const response = await fetch("http://localhost:3001/magazzino/create", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(form),
      });

      console.log(response);
      if (!response.ok) {
        throw new Error("Required not complete");
      }
    } catch (error) {
      console.error(error);
    }
  }

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
                  <h4>{product.nomeAttivita}</h4>
                  <h4>product.description</h4>
                  <h4>product.dateIn</h4>
                  <h4>product.quantity</h4>
                </li>
              ))}
            </ul>
          )} */}
          <p>{products[0].nomeAttivita}</p>
          <p>{products[1].nomeAttivita}</p>
          <form
            onChange={(e) => {
              const { name, value } = e.target;
              setForm((form) => ({
                ...form,
                [name]: value,
              }));
            }}
          >
            <label>
              <h3>Nome Attività</h3>
              <input
                type="text"
                placeholder="Nome Attività"
                className="bg-red-50 border border-red-500"
                name="nomeAttivita"
              />
            </label>
            <Button style="error" text="Save" onClick={handleCreateWarehouse} />
          </form>
        </section>
      </section>
    </>
  );
}
