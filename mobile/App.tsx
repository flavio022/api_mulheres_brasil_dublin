import { StatusBar } from "expo-status-bar";
import { NavigationContainer } from "@react-navigation/native";
import Routes from "./src/routes/app.routes";
import { View } from "react-native";

import React from "react";

const App: React.FC = () => (
  <NavigationContainer>
    <StatusBar barStyle="dark-content" backgroundColor="transparent" />

    <View style={{ flex: 1, backgroundColor: "#312e38" }}>
      <Routes />
    </View>
  </NavigationContainer>
);

export default App;
