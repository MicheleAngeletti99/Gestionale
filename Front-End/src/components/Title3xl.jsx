export function Title3xl({
  text,
  onMouseEnter,
  onMouseLeave,
  cursorPointer = "disable",
  height = "auto",
}) {
  const styleCursorPointer = {
    active: "cursor-pointer",
    disable: "",
  };

  const styleHeightDiv = {
    max: "h-full",
    auto: "h-auto",
  };

  return (
    <h1
      onMouseEnter={onMouseEnter}
      onMouseLeave={onMouseLeave}
      className={`text-3xl ${styleHeightDiv[height]} ${styleCursorPointer[cursorPointer]}`}
    >
      {text}
    </h1>
  );
}
