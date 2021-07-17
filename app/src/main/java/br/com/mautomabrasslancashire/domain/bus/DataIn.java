package br.com.mautomabrasslancashire.domain.bus;

public interface DataIn {
    interface Callback{
        void onSuccess();
        void onError(Throwable throwable);
    }
}
