import React, { useState, useEffect } from "react";
import { useNavigation, useRoute } from "@react-navigation/native";
import { AntDesign } from "@expo/vector-icons";
import { SearchBar } from "react-native-elements";
import api from "../../services/api";
import Header from "../../components/Header";
import filter from "lodash.filter";

import {
  Container,
  Text,
  SectionItem,
  ImageSelection,
  ViewScroll,
  TextSession,
  SectionList,
  ContentHeader,
  TextName,
  TextHeader,
  ButtonDetails
} from "./styles";

interface IParams {
  organization_id: number;
  nome: string;
}
interface ISearch {
  search: string;
}
export interface ISectionItems {
  id: string;
  nome: string;
  institutions: [
    {
      id: string;
      nome: string;
      description: string;
      phone: string;
      email: string;
      webSite: string;
      paymentType: string;
      imageUri: string;
    }
  ];
}
export interface IOrganizationItems {
  name: string;
}
const Section: React.FC = () => {
  const navigation = useNavigation();

  const [data, setData] = useState([]);
  const [section, SetSection] = useState([]);
  const [query, setQuery] = useState("");
  const [fullData, setFullData] = useState([]);

  function handleSubmit() {
    navigation.navigate("Details", {});
  }
  function handlernavigateBack() {
    navigation.goBack();
  }

  const route = useRoute();
  const routeParams = route.params as IParams;

  useEffect(() => {
    api.get(`categories/${routeParams.organization_id}`).then(response => {
      SetSection(response.data);
      setData(response.data);
    });
  }, []);

  const handleSearch = text => {
    const formattedQuery = text.toLowerCase();
    const filteredData = filter(data, user => {
      return contains(user, formattedQuery);
    });
    SetSection(filteredData);
    setQuery(text);
  };
  const contains = ({ nome }: ISectionItems, query) => {
    if (nome.toLowerCase().startsWith(query.toLowerCase())) {
      return true;
    }
    return false;
  };

  return (
    <Container>
      <Header>
        <ContentHeader>
          <AntDesign
            name="left"
            size={24}
            color="#fff"
            onPress={handlernavigateBack}
          />
          <TextHeader>{section.nome}</TextHeader>
        </ContentHeader>
      </Header>
      <ViewScroll>
        <SectionList
          data={section.institutions}
          renderItem={({ item: section }) => (
            <SectionItem onPress={handleSubmit}>
              <ImageSelection
                source={{
                  uri: section.imageUri
                }}
              />
              <TextSession>
                <TextName>{section.nome}</TextName>

                <ButtonDetails>
                  <Text>Detalhes</Text>
                </ButtonDetails>
              </TextSession>
            </SectionItem>
          )}
        />
      </ViewScroll>
    </Container>
  );
};

export default Section;
