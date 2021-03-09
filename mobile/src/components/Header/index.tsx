import React from "react";
import { Container } from "../Header/styles";

const Header: React.FC = ({ children, ...rest }) => {
  return <Container {...rest}>{children}</Container>;
};

export default Header;
