import styled from "styled-components/native";
import { FlatList } from "react-native";
import { ISectionItems, IOrganizationItems } from ".";

export const ViewScroll = styled.ScrollView``;
export const Container = styled.View`
  background: #f3f0dd;
  flex: 1;
`;
export const ContentHeader = styled.View`
  flex-direction: row;
  width: 100%;
  background: #1a1c40;
  height: 150px;
  padding-top: 50px;
`;

export const SectionList = styled(
  FlatList as new () => FlatList<ISectionItems>
)`
  flex: 1;
  padding: 1px 0px 4px 1px;
`;
export const SectionItem = styled.TouchableOpacity`
  width: 100%;
  height: 150px;
  background: #f3f0dd;
  margin: 2px;
  padding: 0px;
  flex-direction: row;
`;

export const Text = styled.Text`
  font-size: 10px;
`;
export const TextHeader = styled.Text`
  font-size: 25px;
  color: #fff;
`;

export const ImageSelection = styled.Image`
  width: 130px;
`;

export const TextSession = styled.View`
  justify-content: center;
  align-items: flex-start;
  flex-direction: column;
  width: 200px;
`;
export const TextName = styled.Text`
  font-size: 20px;
  color: black;
`;
import { RectButton } from "react-native-gesture-handler";
export const ButtonDetails = styled(RectButton)`
  width: 150px;
  height: 20px;
  background: #f2b591;
  border-radius: 25px;
  margin: 15px;
  justify-content: center;
  align-items: center;
`;

export const ViewSearch = styled.View`
  background: #fff;
  padding: 10px;
  margin: 10px;
  border-radius: 20px;
`;

export const TextInputSearch = styled.TextInput`
  background: #fff;
  padding: 20px;
`;
