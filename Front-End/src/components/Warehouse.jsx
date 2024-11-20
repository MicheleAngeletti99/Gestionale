export function Warehouse() {
  return (
    <>
      <section>
        <form
          onChange={(e) => {
            const { name, value } = e.target;
            setForm((form) => ({
              ...form,
              [name]: value,
            }));
          }}
        >
          <TitleXL text="Inserisci Magazzino" />
          <label>
            <h3>Nome Attività</h3>
            <input
              type="text"
              placeholder="Nome Attività"
              className="bg-red-50 border border-red-500"
              name="nomeAttivita"
            />
          </label>
          <label>
            <h3>Indirizzo Attività</h3>
            <input
              type="text"
              placeholder="indirizzo"
              className="bg-red-50 border border-red-500"
              name="indirizzo"
            />
          </label>
          <label>
            <h3>Tipologia Attivita</h3>
            <input
              type="text"
              placeholder="tipologiaAttivita"
              className="bg-red-50 border border-red-500"
              name="tipologiaAttivita"
            />
          </label>
          <Button style="error" text="Save" onClick={handleCreateWarehouse} />
        </form>
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
        {/* <p>{products[0].nomeAttivita}</p>
          <p>{products[1].nomeAttivita}</p> */}
      </section>
    </>
  );
}
