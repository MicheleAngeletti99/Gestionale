import { SlideImage } from "./SlideImage";
import { SlideText } from "./SlideText";

export function Slide({ imageSrc, imageAlt, title, description }) {
  return (
    <div className="relative flex items-center justify-center w-full h-[600px] ">
      <SlideImage src={imageSrc} alt={imageAlt} />
      <div className="absolute inset-0 bg-black opacity-40"></div>
      <div className="absolute inset-0 flex items-end justify-center pb-5">
        <SlideText title={title} description={description} />
      </div>
    </div>
  );
}
