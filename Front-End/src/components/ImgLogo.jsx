export function ImgLogo({ src, alt, style = "primary", onClick }) {
  const imgStyle = {
    primary: "h-12 w-12",
  };

  return (
    <>
      <img
        src={src}
        alt={alt}
        className={`${imgStyle[style]} cursor-pointer`}
        onClick={onClick}
      />
    </>
  );
}
