export function SlideImage({ src, alt }) {
  return (
    <div className="w-full h-full">
      <img src={src} alt={alt} className="object-cover w-full h-full" />
    </div>
  );
}
