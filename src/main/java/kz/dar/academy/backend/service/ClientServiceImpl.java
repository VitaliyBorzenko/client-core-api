package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private static HashMap<String, ClientModel> clientMap = new HashMap<>();

    static {
        ClientModel clientModel1 = new ClientModel("ABC123", "Ivan", "Ivanov", "ex1@mail.ru");
        ClientModel clientModel2 = new ClientModel("ABC234", "Vladimir", "Klimov", "ex2@mail.ru");
        ClientModel clientModel3 = new ClientModel("ABC345", "Andrey", "Vasiliev", "ex3@mail.ru");
        ClientModel clientModel4 = new ClientModel("123ABC", "Almat", "Iskakov", "ex4@mail.ru");
        ClientModel clientModel5 = new ClientModel("234ABC", "Inna", "Samsonova", "ex5@mail.ru");
        ClientModel clientModel6 = new ClientModel("345ABC", "Asel", "Ibrayeva", "ex6@mail.ru");
        clientMap.put(clientModel1.getClientId(), clientModel1);
        clientMap.put(clientModel2.getClientId(), clientModel2);
        clientMap.put(clientModel3.getClientId(), clientModel3);
        clientMap.put(clientModel4.getClientId(), clientModel4);
        clientMap.put(clientModel5.getClientId(), clientModel5);
        clientMap.put(clientModel6.getClientId(), clientModel6);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clientMap.put(clientId, clientModel);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);
    }
}
