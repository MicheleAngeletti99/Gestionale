import { SlideImage } from "./SlideImage";
import { SlideText } from "./SlideText";

export function Slide({ imageSrc, imageAlt, title, description }) {
  return (
    <div className="relative flex items-center justify-center w-full h-[500px] ">
      <SlideImage src={imageSrc} alt={imageAlt} />
      <div className="absolute inset-0 bg-gradient-to-t from-black opacity-50"></div>
      <div className="absolute inset-0 flex items-end justify-center">
        <SlideText title={title} description={description} />
      </div>
    </div>
  );
}
