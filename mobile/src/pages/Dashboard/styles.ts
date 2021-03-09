import styled from "styled-components/native";
import { FlatList } from "react-native";

export const Container = styled.View`
  background: #1a1c40;

  flex: 1;
`;
export const HeaderTittle = styled.Text`
  color: #f2b591;
  font-size: 30px;
  line-height: 28px;
  text-align: center;
`;
export const ImageLogo = styled.Image`
  width: 50px;
  height: 90px;
`;

export const Content = styled.View`
  align-items: center;
  justify-content: flex-start;
  flex: 1;
  padding-top: 20px;
`;
export const TabsContainer = styled.View`
  height: 350px;
  background: #1a1c40;
  width: 100%;
`;
export const TabsContent = styled.ScrollView.attrs({
  horizontal: true,
  contentContainerStyle: {
    paddingLeft: 10,
    paddingTop: 15,
    paddingRight: 20,
    paddingBottom: 20,

    justifyContent: "space-between"
  },
  showsHorizontalScrollIndicator: false
})``;

export const TabsItem = styled.TouchableOpacity`
  width: 200px;
  height: 250px;
  padding: 25px;
  background: #f3f0dd;
  border-radius: 25px;
  margin-left: 10px;
  justify-content: space-between;
  align-items: center;
  flex-direction: column;
`;

export const Text = styled.Text`
  font-size: 25px;
`;

export const ImageSelection = styled.Image`
  width: 100px;
  height: 100px;
  border-radius: 25px;
`;
import { RectButton } from "react-native-gesture-handler";
import { IOrganizationItems } from ".";
export const ButtonDetails = styled(RectButton)`
  width: 80%;
  height: 50px;
  background: #f2b591;
  border-radius: 25px;
  margin-bottom: 10px;
  justify-content: center;
  align-items: center;
`;

export const TextButton = styled.Text`
  font-size: 10px;
`;

export const SectionList = styled(
  FlatList as new () => FlatList<IOrganizationItems>
)`
  padding: 32px 24px 16px;
`;
