import React from "react";
import { useNavigation } from "@react-navigation/native";
import { Container, Text } from "./styles";
import { AntDesign } from "@expo/vector-icons";

const Details: React.FC = () => {
  const navigation = useNavigation();

  function handlernavigateBack() {
    navigation.goBack();
  }
  return (
    <Container>
      <AntDesign
        name="left"
        size={24}
        color="#fff"
        onPress={handlernavigateBack}
      />
      <Text>Olá</Text>
    </Container>
  );
};

export default Details;
