export function LinkPage({ onClick, text, style = "primary" }) {
  const styleText = {
    primary: "text-3xl",
    secondary: "auto",
  };

  return (
    <div onClick={onClick} className={`cursor-pointer ${styleText[style]}`}>
      {text}
    </div>
  );
}
