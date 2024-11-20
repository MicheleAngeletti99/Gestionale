import { useEffect, useState } from "react";
import { Title3xl } from "../components/Title3xl";
import { Button } from "../components/Button";
import { TitleXL } from "../components/TitleXL";
import { LinkPage } from "../components/LinkPage";
import { Input } from "../components/Input";
import { IoIosAdd } from "react-icons/io";

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
      <Title3xl text="Gestionale Home" />
      <section className="flex gap-1 ">
        {/* SideBar */}
        <section className="p-6 bg-slate-400">
          <LinkPage text="Warehouse" />
          <LinkPage text="Warehouse settings" />
          <LinkPage text="Tools View" />
          <LinkPage text="Warehouse" />
        </section>
        {/* Inserimento Attività */}
        <section className="p-6">
          {/* mini nav */}
          <section className="flex gap-3">
            <Button icon={<IoIosAdd />} style="secondary" />
          </section>
          <form
            onChange={(e) => {
              const { name, value } = e.target;
              setForm((form) => ({
                ...form,
                [name]: value,
              }));
            }}
            className="flex flex-col"
          >
            <TitleXL text="Inserisci Magazzino" />
            <Input
              type="text"
              placeholder="Nome Attività"
              name="nomeAttivita"
              text="Nome Attività"
            />
            <Input
              type="text"
              placeholder="Indirizzo"
              name="indirizzo"
              text="Indirizzo Attività"
            />
            <Input
              type="text"
              placeholder="Tipologia Attività"
              name="tipologiaAttivita"
              text="Tipologia Attività"
            />

            <Button
              style="error"
              text="Save Warehouse"
              size="sm"
              onClick={handleCreateWarehouse}
            />
          </form>
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
          {/* <p>{products[0].nomeAttivita}</p>
          <p>{products[1].nomeAttivita}</p> */}
        </section>
      </section>
    </>
  );
}
