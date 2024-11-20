export function SlideText({ title, description }) {
  return (
    <div className="text-center text-white pb-20">
      <h2 className="text-3xl font-semibold mb-2">{title}</h2>
      <p className="text-lg"> {description}</p>
    </div>
  );
}
