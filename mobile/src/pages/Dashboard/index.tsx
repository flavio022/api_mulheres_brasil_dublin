import React, { useState, useEffect } from "react";
import api from "../../services/api";
import { useNavigation } from "@react-navigation/native";
import Header from "../../components/Header";
import logo from "../../assets/logo.png";
import {
  Container,
  HeaderTittle,
  ImageLogo,
  Content,
  TabsContainer,
  TabsContent,
  TabsItem,
  Text,
  ImageSelection,
  ButtonDetails,
  SectionList,
  TextButton
} from "./styles";
import { url } from "inspector";

export interface IOrganizationItems {
  id: number;
  nome: string;
  imageUri: string;
}
const Dashboard: React.FC = () => {
  const [organization, SetOrganization] = useState([]);

  const navigation = useNavigation();

  function handleSubmit() {
    navigation.navigate("Section", {});
  }

  function handlerNavigationToSection(id: number, nome: string) {
    navigation.navigate("Section", { organization_id: id, nome: nome });
  }
  useEffect(() => {
    api.get("categories").then(response => {
      SetOrganization(response.data);
    });
  }, []);
  return (
    <Container>
      <Header>
        <ImageLogo source={logo} />
        <HeaderTittle>Mulheres do Brasil Dublin</HeaderTittle>
      </Header>
      <Content>
        <TabsContainer>
          <TabsContent>
            <SectionList
              horizontal
              data={organization}
              renderItem={({ item: organization }) => (
                <TabsItem
                  onPress={() =>
                    handlerNavigationToSection(
                      organization.id,
                      organization.nome
                    )
                  }
                >
                  <ImageSelection
                    source={{
                      uri: organization.imageUri
                    }}
                  />
                  <Text>{organization.nome}</Text>
                  <ButtonDetails>
                    <TextButton>Saiba mais</TextButton>
                  </ButtonDetails>
                </TabsItem>
              )}
            />
          </TabsContent>
        </TabsContainer>
      </Content>
    </Container>
  );
};

export default Dashboard;
