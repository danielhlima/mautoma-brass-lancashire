package br.com.mautomabrasslancashire.domain.bus;

public interface DataOut {
    interface Callback<O>{
        void onSuccess(O parameter);
        void onError(Throwable throwable);
    }
}
