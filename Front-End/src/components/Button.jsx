export function Button({ onClick, text, style = "primary" }) {
  const buttonStyle = {
    primary:
      "m-1 px-4 py-2 bg-blue-500 text-white rounded-md hover:bg-blue-700 text-bold",
  };
  return (
    <button onClick={onClick} className={buttonStyle[style]}>
      {text}
    </button>
  );
}
