package packet.packetlimiter;

public abstract class ProtocolEvent<T> {
    public abstract void call(ProtocolListener listener);
}
