import { Button } from "./Button";
import { ImgLogo } from "./ImgLogo";
import { ImCheckmark, ImCross } from "react-icons/im";
import Avatar from "../assets/react.svg";

export function Card({ type = "price", tPrice = "Basic", price = "Free" }) {
  const cardPriceInfo = {
    NumeroDiAziende: { description: "Numero di aziende", isAvailable: true },
    NumeroDiMagazzini: { description: "Numero di magazzini", isAvailable: true },
    NumeroDiUtenti: { description: "Numero di utenti", isAvailable: false },
    AssistenzaViaEmail: { description: "Supporto tramite email", isAvailable: true },
    AssistenzaTelefonica: { description: "Supporto telefonico", isAvailable: true },
    Teleassistenza: { description: "Assistenza remota", isAvailable: false },
    FormazioneAllUtilizzo: { description: "Sessioni di formazione", isAvailable: true },
    Personalizzazione: { description: "Personalizzazione", isAvailable: true },
  };

  const cardType = {
    price: "bg-white text-center p-4 rounded-lg shadow-lg border border-black mx-auto my-6 w-96 ",
    service: "bg-blue-100 text-left p-6 rounded-lg shadow-lg max-w-xs mx-auto my-4",
    customer: "bg-green-100 text-center p-4 rounded-lg shadow-lg max-w-xs mx-auto my-4",
  };

  const cardContent = {
    price: (
      <>
        <h2 className="text-lg font-bold p-2 text-blue-500">Piano {tPrice}</h2>
        <h3 className="font-black  text-center p-2">Prezzo: {price}</h3>
        <ul className="text-left">
          {Object.keys(cardPriceInfo)
            .sort((isTrue, isFalse) => cardPriceInfo[isFalse].isAvailable - cardPriceInfo[isTrue].isAvailable)
            .map((info, index) => (
              <li className=" flex justify-between items-center p-2 text-black" key={index}>
                <p>{cardPriceInfo[info].description}</p>
                <p>{cardPriceInfo[info].isAvailable ? <ImCheckmark /> : <ImCross />}</p>
              </li>
            ))}
        </ul>
        <Button size="sm" />
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
