package com.trepudox.bff.infra.webclient;

public interface CargoMessageProducerWebClient {

    void create();

    void update();

    void delete(long id);

}
