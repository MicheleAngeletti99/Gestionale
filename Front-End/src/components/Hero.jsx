import { useEffect, useState } from "react";
import { Slide } from "./Slide";
import { BsArrowLeftShort, BsArrowRightShort } from "react-icons/bs";

export function Hero() {
  const slides = [
    {
      imageSrc: "/src/assets/Slide1.jpg",
      imageAlt: "Slide1",
      title: "StockHub",
      description: `Una piattaforma che ti permette di gestire l'entrate e le uscite del tuo magazzino personale`,
    },
    {
      imageSrc: "/src/assets/Slide2.jpg",
      imageAlt: "Slide2",
      title: "Magazzino On-line",
      description: `Con il magazzino online la gestione delle entrate e delle uscite diventa un gioco da ragazzi`,
    },
  ];
  // gestione dello stato & pulsanti per il carosello
  const [imgIndex, setImgIndex] = useState(0);

  function nextSlide() {
    setImgIndex((prevIndex) => (prevIndex + 1) % slides.length);
  }
  function prevSlide() {
    setImgIndex((prevIndex) => (prevIndex - 1 + slides.length) % slides.length);
  }

  //   autoplay del carosello
  useEffect(() => {
    const intervallo = setInterval(nextSlide, 5000);
    return () => clearInterval(intervallo);
  });

  return (
    <div className="relative w-full h-[600px]">
      <Slide imageSrc={slides[imgIndex].imageSrc} imageAlt={slides[imgIndex].imageAlt} title={slides[imgIndex].title} description={slides[imgIndex].description} />
      <button onClick={prevSlide} className="absolute top-1/2 left-4 transform -translate-y-1/2 text-white text-6xl opacity-25 ">
        <BsArrowLeftShort />
      </button>
      <button onClick={nextSlide} className="absolute top-1/2 right-4 transform -translate-y-1/2 text-white text-6xl opacity-25">
        <BsArrowRightShort />
      </button>
    </div>
  );
}
