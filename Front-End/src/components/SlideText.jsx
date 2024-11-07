export function SlideText({ title, description }) {
  return (
    <div className="p-4 text-white">
      <h2 className="text-2xl font-bold">{title}</h2>
      <p className="mt-2"> {description}</p>
    </div>
  );
}
