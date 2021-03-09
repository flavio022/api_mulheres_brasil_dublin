import React from "react";
import Button from "../../components/Button";
import Header from "../../components/Header";

import back from "../../assets/mulheres.png";
import logo from "../../assets/logo.png";
import {
  Container,
  HeaderTittle,
  Image,
  ImageLogo,
  Content,
  Footer,
  Text
} from "./styles";
import { useNavigation } from "@react-navigation/native";

const Landing: React.FC = () => {
  const navigation = useNavigation();

  function handleSubmit() {
    navigation.navigate("Dashboard", {});
  }
  return (
    <Container>
      <Header>
        <ImageLogo source={logo} />
        <HeaderTittle>Mulheres do Brasil Dublin</HeaderTittle>
      </Header>
      <Content>
        <Image source={back} />
        <Text>CONSTRUIR UM BRASIL MELHOR</Text>
        <Text>a partir do protagonismo feminino.</Text>
      </Content>
      <Footer>
        <Button onPress={handleSubmit} children={"Get start"} />
      </Footer>
    </Container>
  );
};

export default Landing;
