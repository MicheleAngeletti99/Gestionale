export function Button({
  text = "Button",
  onClick,
  style = "primary",
  size = "sm",
  fontSize = "primary",
}) {
  const buttonStyle = {
    primary: "m-1 bg-blue-500 text-white rounded-md hover:bg-blue-700",
    secondary: "m-1 bg-gray-500 text-white rounded-md hover:bg-gray-700",
    error: "m-1 bg-red-500 text-white rounded-md hover:bg-red-700",
    warning: "m-1 bg-yellow-500 text-white rounded-md hover:bg-yellow-700",
    circle: "aspect-square bg-yellow-500 rounded-full",
  };

  const buttonSize = {
    sm: "px-1 py-1",
    md: "px-2 py-2",
    lg: "px-3 py-2",
    xlg: "px-4 py-2",
  };

  const buttonFont = {
    primary: "text-base",
    secondary: "text-lg",
    thirdy: "text-3xl",
  };

  return (
    <button
      className={`${buttonStyle[style]} ${buttonSize[size]} ${buttonFont[fontSize]}`}
      onClick={onClick}
    >
      {text}
    </button>
  );
}
