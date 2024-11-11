import { Button } from "./Button";
import { ImgLogo } from "./ImgLogo";
import Avatar from "../assets/react.svg";

export function Card({ type = "price" }) {
  const cardType = {
    price: "bg-white text-center p-4 rounded-lg shadow-xl max-w-xs mx-auto my-4",
    service: "bg-blue-100 text-left p-6 rounded-lg shadow-lg max-w-xs mx-auto my-4",
    customer: "bg-green-100 text-center p-4 rounded-lg shadow-lg max-w-xs mx-auto my-4",
  };

  const cardContent = {
    price: (
      <>
        <h3 className="text-lg font-bold mb-2 ">Piano Prezzi</h3>
        <p className="text-gray-700 mb-4">€19,99 / mese</p>
        <Button size="lg" style="error" />
      </>
    ),
    service: (
      <>
        <h3 className="text-lg font-bold mb-2">Servizio</h3>
        <p className="text-gray-700 mb-4">Descrizione del nostro servizio principale con tutti i dettagli che i clienti devono sapere.</p>
      </>
    ),
    customer: (
      <>
        <h3 className="text-lg font-bold mb-2">Testimonianza Cliente</h3>
        <ImgLogo style="primary" src={Avatar} />
        <p className="text-gray-700 mb-4">Servizio eccellente! Mi ha aiutato tantissimo a risolvere i miei problemi.</p>
        <p className="text-sm text-gray-500">- Nome Cliente</p>
      </>
    ),
  };

  return <div className={cardType[type]}>{cardContent[type]}</div>;
}
