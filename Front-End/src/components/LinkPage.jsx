export function LinkPage({ onClick, text, onMouseEnter, onMouseLeave }) {
  return (
    <div
      onClick={onClick}
      onMouseEnter={onMouseEnter}
      onMouseLeave={onMouseLeave}
      className="text-3xl cursor-pointer"
    >
      {text}
    </div>
  );
}
