/**
 * This class is generated by jOOQ
 */
package generated;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.4"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

	/**
	 * The sequence <code>public.system_sequence_61e607a2_285e_4057_b779_5aa66af5986d</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_61E607A2_285E_4057_B779_5AA66AF5986D = new SequenceImpl<Long>("system_sequence_61e607a2_285e_4057_b779_5aa66af5986d", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);

	/**
	 * The sequence <code>public.system_sequence_98ef2600_1bbe_4627_9df5_03351e4332a9</code>
	 */
	public static final Sequence<Long> SYSTEM_SEQUENCE_98EF2600_1BBE_4627_9DF5_03351E4332A9 = new SequenceImpl<Long>("system_sequence_98ef2600_1bbe_4627_9df5_03351e4332a9", Public.PUBLIC, org.jooq.impl.SQLDataType.BIGINT);
}
