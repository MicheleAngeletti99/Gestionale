export function LinkPage({ onClick, text }) {
  return (
    <div onClick={onClick} className="text-3xl">
      {text}
    </div>
  );
}
