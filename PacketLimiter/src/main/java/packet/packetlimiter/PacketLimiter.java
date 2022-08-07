package packet.packetlimiter;

import com.sun.tools.jdi.Packet;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;



public final class PacketLimiter extends JavaPlugin implements Listener {


    public class PacketSendEvent extends ProtocolEvent<ProtocolListener> {

        /**
         * The sent packet.
         */
        private Packet packet;

        /**
         * Creates a new packet send event instance.
         * @param packet Packet being sent.
         */
        public PacketSendEvent(Packet packet) {
            this.packet = packet;
        }

        /**
         * Gets the sent packet.
         * @return The sent packet.
         */
        public Packet getPacket() {
            return this.packet;
        }

        /**
         * Gets and casts the sent packet to the given type.
         * @param clazz Class to cast to.
         * @return The sent packet, or null if it is not of that type.
         */
        @SuppressWarnings("unchecked")
        public <T extends Packet> T getPacket(Class<T> clazz) {
            try {
                return (T) this.packet;
            } catch(ClassCastException e) {
                return null;
            }
        }

        @Override
        public void call(ProtocolListener listener) {
            listener.onPacketSend(this);
        }

    }


}
