import React, { ButtonHTMLAttributes } from "react";
import { Container } from "./styled";
import { boolean } from "yup";

type ButtonProps = ButtonHTMLAttributes<HTMLButtonElement> & {
  loading?: boolean;
};

export const Button: React.FC<ButtonProps> = ({
  children,
  loading,
  ...rest
}) => (
  <Container type="button" {...rest}>
    {loading ? "Enviando Email..." : children}
  </Container>
);
export default Button;
